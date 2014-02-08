# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "breadless"
  config.vm.box_url = "http://files.vagrantup.com/precise64.box"

  config.vm.synced_folder ".", "/home/vagrant/src/breadless"

  config.vm.define :db do |db|
    db.vm.hostname = "db.dev.breadless.local"
    db.vm.provider :virtualbox do |v, override|
      override.vm.network :private_network, ip: "192.168.120.101"
      v.customize ["modifyvm", :id, "--memory", 4096]
    end
    db.vm.provider :vmware_fusion do |v, override|
      override.vm.box_url = "http://files.vagrantup.com/precise64_vmware.box"
      override.vm.network :private_network, ip: "192.168.160.101"
      v.vmx["memsize"] = "4096"
      v.vmx["numvcpus"] = "4"
      v.vmx["displayName"] = "redparrot_db"
    end
    db.vm.provision :puppet do |puppet|
      puppet.manifests_path = "puppet/manifests"
      puppet.module_path    = "puppet/modules"
      puppet.manifest_file = "db.pp"
      puppet.facter = {
        "host_environment" => "Vagrant"
      }
      puppet.options = "--verbose"
    end
  end
end

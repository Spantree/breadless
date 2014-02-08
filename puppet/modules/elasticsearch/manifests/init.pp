class elasticsearch(
	$version = "0.90.0"
) {
	wget::fetch { "fetch-elasticsearch":
		source => "https://download.elasticsearch.org/elasticsearch/elasticsearch/elasticsearch-${version}.deb",
		destination => "/tmp/elasticsearch-${version}.deb",
		verbose => true
	}

	package { "elasticsearch":
		provider => dpkg,
 		ensure   => latest,
 		source   => "/tmp/elasticsearch-${version}.deb",
 		require	 => [
 			Wget::Fetch["fetch-elasticsearch"],
 			Class["java7"]
 		]
	}

	service { "elasticsearch":
	    enable => true,
		ensure => running,
		hasstatus => true,
		require => [
			File['/etc/init.d/elasticsearch'],
			File['/etc/elasticsearch/elasticsearch.yml'],
			File['/etc/elasticsearch/logging.yml'],
			Package['elasticsearch']
		]
	}

	file { "/etc/init.d/elasticsearch":
		owner => root,
		group => root,
		mode => 744,
		ensure => present,
		source => "puppet:///modules/elasticsearch/etc/init.d/elasticsearch",
		notify => Service["elasticsearch"],
	}

	file { "/etc/elasticsearch":
		ensure => directory
	}

	file { "/etc/elasticsearch/elasticsearch.yml":
		ensure => file,
		content => template("elasticsearch/elasticsearch.yml.erb"),
		require => File['/etc/elasticsearch'],
		notify => Service["elasticsearch"],
	}

	file { "/etc/elasticsearch/logging.yml":
		ensure => present,
		recurse => true,
		source => "puppet:///modules/elasticsearch/etc/elasticsearch/logging.yml",
		require => File['/etc/elasticsearch'],
		notify => Service["elasticsearch"],
	}

	exec { "install-head-plugin":
		command => "/usr/share/elasticsearch/bin/plugin -install mobz/elasticsearch-head",
		require => Service["elasticsearch"]
	}

	exec { "install-bigdesk-plugin":
		command => "/usr/share/elasticsearch/bin/plugin -install lukas-vlcek/bigdesk",
		require => Service["elasticsearch"]
	}

	exec { "install-skywalker-plugin":
		command => "/usr/share/elasticsearch/bin/plugin -install jprante/elasticsearch-skywalker/1.1.0",
		require => Service["elasticsearch"]
	}

	exec { "install-knapsack-plugin":
		command => "/usr/share/elasticsearch/bin/plugin -u http://dl.bintray.com/jprante/elasticsearch-plugins/org/xbib/elasticsearch/plugin/elasticsearch-knapsack/2.0.0/elasticsearch-knapsack-2.0.0.zip -i knapsack",
		require => Service["elasticsearch"]
	}
}
node /(.*breadless.*)/ {
  stage { 'bootstrap':
    before => Stage['first'],
  }
  stage { 'first':
    before => Stage['main'],
  }
  stage { 'last': }
  Stage['main'] -> Stage['last']

  class { 'aptupdate': stage => 'bootstrap' }

  class { 'java7': }

  class { 'mongodb':
    ulimit_nofile => 20000,
  }

  class { 'elasticsearch': 
    version => '0.90.3',
  }

   class { 'redis':
      version => '2.6.5',
  }

  if $host_environment == 'Vagrant' {
    host { 'db.dev.breadless.internal':
      ensure       => present,
      ip           => '192.168.120.101',
      host_aliases => [
        'mongo.dev.breadless.internal',
        'elasticsearch.dev.breadless.internal',  ],
    }
  }
  
}

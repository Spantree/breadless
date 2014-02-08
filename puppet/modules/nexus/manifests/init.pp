class nexus(
  $version = '2.6.1-02',
  $group = 'nexus',
  $groupId = '1010',
  $user = 'nexus',
  $userPassword = 'nexus',
  $userId = '1010',
  $working_directory = '/var/nexus',
) {
  group { $group:
    ensure  => present,
    gid     => $groupId,
  }

  user { $user:
    ensure     => present,
    uid        => $userId,
    gid        => $groupId,
    home       => "/home/${user}",
    shell      => '/bin/bash',
    managehome => true,
    password   => sha1($userPassword),
    require    => Group[$group]
  }

  archive { "nexus-${version}":
    ensure   => present,
    url      => "http://www.sonatype.org/downloads/nexus-${version}-bundle.tar.gz",
    target   => '/usr/local/',
    checksum => false,
    require  => User[$user]
  }

  file { 'nexus-reown-build':
    path    => "/usr/local/nexus-${version}",
    owner   => $user,
    group   => $group,
    backup  => false,
    recurse => true,
    require => Archive["nexus-${version}"]
  }

  file { '/usr/local/nexus':
    ensure  => symlink,
    target  => "/usr/local/nexus-${version}",
    owner   => $user,
    group   => $group,
    backup  => false,
    require => File['nexus-reown-build']
  }

  file { $working_directory:
    ensure  => directory,
    owner   => $user,
    group   => $user,
    recurse => true
  }

  file { '/usr/local/nexus/conf/nexus.properties':
    ensure  => file,
    content => template('nexus/nexus.properties.erb'),
    require => [
      File['/usr/local/nexus'],
      File[$working_directory],
    ]
  }

  upstart::job { 'nexus-service':
    description    => 'Sonatype Nexus',
    version        => '1.0',
    respawn        => true,
    respawn_limit  => '5 10',
    user           => $user,
    group          => $group,
    chdir          => '/usr/local/nexus',
    exec           => 'bin/nexus start',
    require        => File['/usr/local/nexus/conf/nexus.properties']
  }

  file { '/var/log/nexus':
    ensure  => symlink,
    target  => '/usr/local/nexus/logs',
    owner   => $user,
    group   => $group,
    backup  => false,
    require => Upstart::Job['nexus-service']
  }
}

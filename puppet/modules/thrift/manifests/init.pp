class thrift {
  apt::ppa { 'ppa:gasol-wu/precise': }

  package { 'libthrift-java':
    require => Apt::Ppa['ppa:gasol-wu/precise']
  }

  package { 'thrift-compiler':
    require => Apt::Ppa['ppa:gasol-wu/precise']
  }
}
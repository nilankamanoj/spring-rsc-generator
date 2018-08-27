import sys
from os import remove

sys.path.append('../')

modelPkg = 'com.github.nilankamanoj.system.model'
repoPkg = 'com.github.nilankamanoj.system.repository'
servicePkg = 'com.github.nilankamanoj.system.service'
controllerPkg = 'com.github.nilankamanoj.system.controller'
idType = 'Integer'
reposPrefx = ''
reposSufx = 'Repository'
servicesPrefx = ''
servicesSufx = 'Service'
controllersPrefx = ''
controllersSufx = 'Controller'
confirm = 'y'

from generator import loadModels,createFiles

models = loadModels()
createFiles(models)

remove('../generator.pyc')


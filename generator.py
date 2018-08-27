from os import listdir, makedirs
from os.path import isfile, join, exists

from __main__ import *
print '\033[32m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\033[0m\n'
print '\033[94m'+'||=====      '+'\033[92m' + ' ======    '+'\033[93m'+'   ====='
print '\033[94m'+'||     \\\\  '+'\033[92m' + ' //          '+'\033[93m'+' //'
print '\033[94m'+'||      ||  ' + '\033[92m'+'||          '+'\033[93m'+'||'
print '\033[94m'+'||      //   '+'\033[92m' + '\\\\         '+'\033[93m'+'||'
print '\033[94m'+'||=====      '+'\033[92m' + '  =====    '+'\033[93m'+'||'
print '\033[94m'+'||     \\\\  '+'\033[92m' + '         \\\\  '+'\033[93m'+'||'
print '\033[94m'+'||      ||   '+'\033[92m' + '        || '+'\033[93m'+'||'
print '\033[94m'+'||      ||   ' + '\033[92m'+'       //  '+'\033[93m'+' \\\\'
print '\033[94m'+'||       \\\\'+'\033[92m' + '  ======     '+'\033[93m'+'   =====\033[0m'
print 'Spring \033[94mR\033[0mepository-\033[92mS\033[0mervice-\033[93mC\033[0montroller generator'
print 'v 1.0.0 \n\033[100mcopyrights : Nilanka manoj\033[0m'
print 'Repository : https://github.com/nilankamanoj/spring-rsc-generator'
print '\033[32m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\033[0m\n'

# common imports for repository, service and controllers
IMPORT_MAP = {
    'jpa_repo': 'org.springframework.data.jpa.repository.JpaRepository',
    'autowire': 'org.springframework.beans.factory.annotation.Autowired',
    'service': 'org.springframework.stereotype.Service',
    'list': 'java.util.List',
    'http_status': 'org.springframework.http.HttpStatus',
    'request_mapping': 'org.springframework.web.bind.annotation.RequestMapping',
    'response_entity': 'org.springframework.http.ResponseEntity',
    'controller': 'org.springframework.stereotype.Controller',
    'request_method': 'org.springframework.web.bind.annotation.RequestMethod',
    'path_variable': 'org.springframework.web.bind.annotation.PathVariable',
    'request_body': 'org.springframework.web.bind.annotation.RequestBody'
}

# exception cases for plurals
ABERRANT_PLURAL_MAP = {
    'appendix': 'appendices',
    'barracks': 'barracks',
    'cactus': 'cacti',
    'child': 'children',
    'criterion': 'criteria',
    'deer': 'deer',
    'echo': 'echoes',
    'elf': 'elves',
    'embargo': 'embargoes',
    'focus': 'foci',
    'fungus': 'fungi',
    'goose': 'geese',
    'hero': 'heroes',
    'hoof': 'hooves',
    'index': 'indices',
    'knife': 'knives',
    'leaf': 'leaves',
    'life': 'lives',
    'man': 'men',
    'mouse': 'mice',
    'nucleus': 'nuclei',
    'person': 'people',
    'phenomenon': 'phenomena',
    'potato': 'potatoes',
    'self': 'selves',
    'syllabus': 'syllabi',
    'tomato': 'tomatoes',
    'torpedo': 'torpedoes',
    'veto': 'vetoes',
    'woman': 'women',
}

# vowel set for pluralize
VOWELS = set('aeiou')

# pluralize singular nouns for listNames


def pluralize(singular):
    if not singular:
        return ''
    plural = ABERRANT_PLURAL_MAP.get(singular)
    if plural:
        return plural
    root = singular
    try:
        if singular[-1] == 'y' and singular[-2] not in VOWELS:
            root = singular[:-1]
            suffix = 'ies'
        elif singular[-1] == 's':
            if singular[-2] in VOWELS:
                if singular[-3:] == 'ius':
                    root = singular[:-2]
                    suffix = 'i'
                else:
                    root = singular[:-1]
                    suffix = 'ses'
            else:
                suffix = 'es'
        elif singular[-2:] in ('ch', 'sh'):
            suffix = 'es'
        else:
            suffix = 's'
    except IndexError:
        suffix = 's'
    plural = root + suffix
    return plural

# load model class names from model package


def loadModels():
    models = [f[:-5] for f in listdir('src/main/java/'+modelPkg.replace(
        '.', '/')+'/') if isfile(join('src/main/java/'+modelPkg.replace('.', '/')+'/', f))]
    return models

# class creation data generation for each model


def createModelData(model):
    data = {}
    data['model'] = model
    data['attribute_single'] = model[0].lower() + model[1:]
    data['attribute_plural'] = pluralize(data['attribute_single'])
    data['class_repository'] = reposPrefx + model + reposSufx
    data['attribute_repository'] = data['class_repository'][0].lower() + \
        data['class_repository'][1:]
    data['class_service'] = servicesPrefx+model+servicesSufx
    data['attribute_service'] = data['class_service'][0].lower() + \
        data['class_service'][1:]
    data['class_controller'] = controllersPrefx + model + controllersSufx
    data['model_location'] = modelPkg+'.'+model
    data['repository_location'] = repoPkg + '.' + data['class_repository']
    data['service_location'] = servicePkg + '.' + data['class_service']
    data['folder_repository'] = 'src/main/java/' + \
        repoPkg.replace('.', '/') + '/'
    data['file_repository'] = data['folder_repository'] + \
        data['class_repository'] + '.java'
    data['folder_service'] = 'src/main/java/' + \
        servicePkg.replace('.', '/') + '/'
    data['file_service'] = data['folder_service'] + \
        data['class_service'] + '.java'
    data['folder_controller'] = 'src/main/java/' + \
        controllerPkg.replace('.', '/') + '/'
    data['file_controller'] = data['folder_controller'] + \
        data['class_controller'] + '.java'
    return data

# create new files/ foldes


def createFiles(models):
    for model in models:

        data = createModelData(model)

        if not exists(data.get('folder_repository')):
            makedirs(data.get('folder_repository'))
            print '\033[94m' + 'create '+'\033[0m' + \
                ': ' + data.get('folder_repository')
        if not exists(data.get('folder_service')):
            makedirs(data.get('folder_service'))
            print '\033[94m' + 'create '+'\033[0m' + \
                ': ' + data.get('folder_service')
        if not exists(data.get('folder_controller')):
            makedirs(data.get('folder_controller'))
            print '\033[94m' + 'create '+'\033[0m' + \
                ': ' + data.get('folder_controller')

        with open(data.get('file_repository'), 'w') as f:
            f.write('package '+repoPkg+';\n\nimport '+IMPORT_MAP.get('jpa_repo')+';\nimport '+data.get('model_location') +
                    ';\n\npublic interface '+data.get('class_repository')+' extends JpaRepository<'+model+', '+idType+'> {\n\n}')
            print '\033[92m' + 'create'+'\033[0m' + \
                ' : ' + data.get('file_repository')
        with open(data.get('file_service'), 'w') as f2:
            f2.write('package '+servicePkg+';\n\nimport '+IMPORT_MAP.get('autowire')+';\nimport '+IMPORT_MAP.get('service')+';\nimport '+data.get('model_location')+';\nimport '+data.get('repository_location')+';\nimport '+IMPORT_MAP.get('list')+';\n\n@Service\npublic class '+data.get('class_service')+' {\n\t@Autowired\n\tprivate '+data.get('class_repository')+' '+data.get('attribute_repository')+';\n\n\tpublic List<'+model+'> findAll() {\n\t\tList<'+model+'> '+data.get('attribute_plural')+' = '+data.get('attribute_repository')+'.findAll();\n\t\treturn '+data.get(
                'attribute_plural')+';\n\t}\n\n\tpublic '+model+' findOne('+idType+' id) {\n\t\t'+model+' '+data.get('attribute_single')+' = '+data.get('attribute_repository')+'.findOne(id);\n\t\treturn '+data.get('attribute_single')+';\n\t}\n\n\tpublic '+model+' save('+model + ' ' + data.get('attribute_single')+') {\n\t\t'+data.get('attribute_repository')+'.save('+data.get('attribute_single')+');\n\t\t'+model+' new'+model+' = '+data.get('attribute_repository')+'.findOne('+data.get('attribute_single')+'.getId());\n\t\treturn new'+model+';\n\t}\n\n}')
            print '\033[92m' + 'create'+'\033[0m' + \
                ' : ' + data.get('file_service')
        with open(data.get('file_controller'), 'w') as f3:
            f3.write('package '+controllerPkg+';\n\nimport '+IMPORT_MAP.get('autowire')+';\nimport '+IMPORT_MAP.get('http_status')+';\nimport '+IMPORT_MAP.get('request_method')+';\nimport '+IMPORT_MAP.get('request_mapping')+';\nimport '+IMPORT_MAP.get('list')+';\nimport '+IMPORT_MAP.get('response_entity')+';\nimport '+IMPORT_MAP.get('path_variable')+';\nimport '+IMPORT_MAP.get('request_body')+';\nimport '+IMPORT_MAP.get('controller')+';\nimport '+data.get(
                'model_location')+';\nimport '+data.get('service_location')+';\n\n@Controller\n@RequestMapping(path = "/'+data.get('attribute_single')+'")\npublic class '+data.get('class_controller')+'{\n\t@Autowired\n\tprivate '+data.get('class_service')+' '+data.get('attribute_service')+';\n\n\t@RequestMapping(path = "/", method = RequestMethod.GET)\n\tpublic ResponseEntity<?> findAll() {\n\t\tList<'+model+'> '+data.get('attribute_plural')+' = '+data.get('attribute_service')+'.findAll();\n\t\treturn new ResponseEntity<>('+data.get('attribute_plural')+', HttpStatus.OK);\n\t}\n\n\t@RequestMapping(path = "/{'+'id}", method = RequestMethod.GET)\n\tpublic ResponseEntity<?> findOne(@PathVariable Integer id) {\n\t\t'+model+' '+data.get('attribute_single')+' = '+data.get('attribute_service')+'.findOne(id);\n\t\treturn new ResponseEntity<>('+data.get('attribute_single')+', HttpStatus.OK);\n\t}\n\n\t@RequestMapping(path = "/", method = RequestMethod.POST)\n\tpublic ResponseEntity<?> save(@RequestBody '+model+' '+data.get('attribute_single')+') {\n\t\t'+model+' new'+model+' = '+data.get('attribute_service')+'.save('+data.get('attribute_single')+');\n\t\treturn new ResponseEntity<>( new'+model+', HttpStatus.OK);\n\t}\n}')
            print '\033[92m' + 'create'+'\033[0m' + \
                ' : ' + data.get('file_controller')


if __name__ == '__main__':
    confirm = 'n'
    while(confirm != 'y'):
        modelPkg = raw_input("model package : ")
        repoPkg = raw_input("repository package : ")
        servicePkg = raw_input("service package : ")
        controllerPkg = raw_input("controller package : ")
        idType = raw_input("model id type : ")

        reposPrefx = raw_input("class name prefix for repositories : ")
        reposSufx = raw_input("class name sufix for repositories : ")

        servicesPrefx = raw_input("class name prefix for services : ")
        servicesSufx = raw_input("class name sufix for services : ")

        controllersPrefx = raw_input("class name prefix for controllers : ")
        controllersSufx = raw_input("class name sufix for controllers : ")
        print '\033[93m' + \
            '======================= input data =============================' + \
            '\033[0m'
        print 'models : '+modelPkg + '\nrepository : '+repoPkg + '\nservice : ' + servicePkg + '\ncontroller : '+controllerPkg + '\nid type : '+idType + '\nrepository prefix : '+reposPrefx + \
            '\nrepository suffix : '+reposSufx + '\nservice prefix : '+servicesPrefx + '\nservice sufix : ' + \
            servicesSufx + '\ncontroller prefix : '+controllersPrefx + \
            '\ncontroller sufix : '+controllersSufx
        print '\033[93m' + \
            '======================= confirmation =============================' + \
            '\033[0m'
        while(True):
            confirm = raw_input('confirm ? y/n : ')
            if(confirm in ['y', 'n']):
                break
        models = loadModels()
        createFiles(models)
        print '\033[93m' + \
            '======================= done =============================' + \
            '\033[0m'

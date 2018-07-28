# testRepository

Проект тестирования rest api

Для запуска проекта на локальном компьютере необходимо будет установить:

Intellij IDEA

С официального сайта https://www.jetbrains.com/idea/ , выбрав нужную операционную систему (Windows/macOs/Linux) и версию Community (бесплатная версия) / Ultimate (бесплатно 30 дней), скачать и установить программу (установка по умолчанию).


2) JAVA

На официальном сайте Oracle скачать Java SE Development Kit последней версии (не JRE!). Для этого необходимо пройти по ссылке http://www.oracle.com/technetwork/java/javase/downloads/index.html, нажать на значок загрузки, принять соглашение Accept License Agreement (выбрав нужный радиобаттон) и скачать загрузочный файл согласно операционной системе. Установить скаченное приложение по умолчанию.

Теперь необходимо настроить переменную JAVA_HOME. На примере macOS: открыть терминал и выполнить команду echo export «JAVA_HOME=\$(/usr/libexec/java_home)» >> ~/.bash_profile , затем нужно перезапустить терминал и проверяем, что все верно установилось выполнив команду echo JAVA_HOME и должен показаться путь, где расположена jdk.


3)  Apache Maven

На офицальном русском можно посмотреть инструкцию по установке  Apache Maven http://www.apache-maven.ru/install.html : cкачать последнюю версию https://maven.apache.org/download.cgi (Binary zip archive). Лучше переместить файл в корень основного диска. Затем выполнить две команды для создания переменных M2_HOME и PATH в файле .bash_profile:
export M2_HOME=/Users/USER_NAME/apache-maven-VERSION/
export PATH=$PATH:$M2_HOME/bin
Перезапустить консоль и командой mvn —version проверить, что мавен установился.
FROM tomcat:8-jdk8
MAINTAINER Michael Büchner <m.buechner@dnb.de>
ENV RUN_USER tomcat
ENV RUN_GROUP 0
ENV JAVA_HOME $JRE_HOME
ENV TOMCAT_HOME $CATALINA_HOME
ENV CATALINA_OPTS "-noverify"
RUN apt-get update && apt-get install -y ant git && \
	git clone https://github.com/mint-ntua/Mint2.git /mint2 && \
	git config --global core.autocrlf input
WORKDIR /mint2
COPY patches/* ./
RUN for filename in *.patch; do git apply "$filename" && rm -f "$filename"; done && \
	rm -rf /mint2/.git && \
	apt-get purge -y git && \
	apt-get auto-remove -y && \
	apt-get auto-clean -y
RUN mkdir custom/mint2 && mkdir WEB-INF/custom/mint2 && mkdir WEB-INF/deploy/mint2 && mkdir WEB-INF/deploy/mint2@ddbkultur
COPY ddbkultur_deploy.xml WEB-INF/deploy/mint2@ddbkultur/deploy.xml
COPY ddbkultur_hibernate.properties WEB-INF/deploy/mint2@ddbkultur/hibernate.properties
COPY ddbkultur_log4j.properties WEB-INF/deploy/mint2@ddbkultur/log4j.properties
COPY ddbkultur_mint.properties WEB-INF/deploy/mint2@ddbkultur/mint.properties
COPY schemas/ schemas/
COPY scripts/ scripts/
RUN ant -Dappname=ROOT -Dcustom=mint2 -Ddeploy_target=mint2@ddbkultur -Ddeploy_local=true deploy
RUN groupadd -r ${RUN_GROUP} && useradd -g ${RUN_GROUP} -d ${CATALINA_HOME} -s /bin/bash ${RUN_USER} && \
	chown -R ${RUN_USER}:${RUN_GROUP} ${CATALINA_HOME} && \
	chmod -R 777 ${CATALINA_HOME}/webapps && \
	chmod -R 777 ${CATALINA_HOME}/conf
EXPOSE 8080

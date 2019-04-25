FROM maven:3.5.2-jdk-8
COPY pom.xml /app/pom.xml
WORKDIR /app

RUN apt update && apt install -y firefox-esr \
  	&& wget https://github.com/mozilla/geckodriver/releases/download/v0.19.1/geckodriver-v0.19.1-linux64.tar.gz\
	&& tar -C /usr/bin/ -xvf geckodriver-v0.19.1-linux64.tar.gz \
    && wget https://download-installer.cdn.mozilla.net/pub/firefox/nightly/latest-mozilla-central/firefox-68.0a1.en-US.linux-x86_64.tar.bz2\
    && tar -C /opt/ -xvf firefox-68.0a1.en-US.linux-x86_64.tar.bz2 \
    && rm /usr/bin/firefox \
    && ln -s  /opt/firefox/firefox /usr/bin/firefox 
	
RUN mvn clean compile test 

COPY . /app

CMD mvn -Dmaven.repo.local=/m2 test
# MariaDB 10.6 버전을 베이스 이미지로 사용
FROM mariadb:10.6

# init.sql 파일을 /docker-entrypoint-initdb.d/ 로 복사하여 컨테이너가 처음 실행될 때 자동으로 실행되도록 함
COPY ./init/init.sql /docker-entrypoint-initdb.d/

# MariaDB의 설정 파일을 /etc/mysql/conf.d/ 에 복사하여 기본 설정 파일을 덮어씌움
COPY ./config/mariadb.conf /etc/mysql/conf.d/

# 계정 정보 설정
ENV MYSQL_ROOT_PASSWORD=myrootpassword
ENV MYSQL_DATABASE=mydb
ENV MYSQL_USER=myuser
ENV MYSQL_PASSWORD=mypassword

# 포트 노출
EXPOSE 3306

# 컨테이너가 시작될 때 실행할 기본 명령 설정
CMD ["mysqld"]
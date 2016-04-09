FROM viticlick/myroutebase
MAINTAINER Víctor López <vlopez.gal@gmail.com>

USER postgres

COPY ./db_setup.sql ./db_setup.sql

RUN /etc/init.d/postgresql start \
  && psql --command "CREATE USER invitado WITH SUPERUSER PASSWORD 'invitado';" \
  && createdb -O invitado raspberry \
  && psql -d raspberry -a -f db_setup.sql

CMD /etc/init.d/postgresql start && psql -d raspberry

FROM viticlick/myroutebase
MAINTAINER Víctor López <vlopez.gal@gmail.com>

USER postgres

COPY ./db_setup.sql ./db_setup.sql

RUN /etc/init.d/postgresql start \
  && psql --command "CREATE USER iot WITH SUPERUSER PASSWORD 'gpul';" \
  && createdb -O iot iotlabs \
  && psql -d iotlabs -a -f db_setup.sql

CMD /etc/init.d/postgresql start && psql -d iotlabs

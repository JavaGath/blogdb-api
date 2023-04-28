FROM postgres:15.2
LABEL maintainer="Ievgenii Izrailtenko"
ENV LANG en_US.utf-8
COPY init.sql /docker-entrypoint-initdb.d/

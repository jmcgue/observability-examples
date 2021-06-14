FROM fluentd:latest

USER root

RUN fluent-gem i -N fluent-plugin-grafana-loki:1.2.12

USER fluent

ENTRYPOINT ["tini", "--", "/bin/entrypoint.sh"]

CMD [ "fluentd" ]
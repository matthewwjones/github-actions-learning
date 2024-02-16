FROM fedora:39
ARG gh_token
RUN mkdir actions-runner
WORKDIR /actions-runner
RUN curl -o actions-runner-linux-x64-2.313.0.tar.gz -L \
      https://github.com/actions/runner/releases/download/v2.313.0/actions-runner-linux-x64-2.313.0.tar.gz && \
    tar xzf ./actions-runner-linux-x64-2.313.0.tar.gz && \
    export RUNNER_ALLOW_RUNASROOT=1 && \
    ./bin/installdependencies.sh  && \
    ./config.sh --unattended \
        --url https://github.com/matthewwjones/github-actions-learning \
        --token $gh_token \
        --name fedora-action-runner \
        --replace \
        --labels 'fedora-action-runner'

ENTRYPOINT RUNNER_ALLOW_RUNASROOT=1 ./run.sh
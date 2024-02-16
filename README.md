# github-actions-learning
A simple repo to support GH Actions learning exercises.

## Docker Build

To run a Docker build for the GH Action runner:

```bash
$ docker build --build-arg gh_token=<your GitHub runner registration token> -t gh-agent:latest .
```

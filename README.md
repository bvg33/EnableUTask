# Monitoring service

Monitoring service is an application which can help you monitor availability of URL. It will send emails to you with information about URL status.

## Build

To build this application you can use gradle.

```bash
$ gradle build
```

## Deploy

To deploy this app to Docker I added Dockerfile and startDocker.bat
After building the project you just need to run startDocker.bat file and application will be deployed to Docker.
If you need to change some parameters you can modify files that I mentioned above.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

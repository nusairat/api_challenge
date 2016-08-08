# API Challenge

## Dependencies

This project uses Gradle for builds.
You need Java 8 installed.

## Endpoints
/dogs/list/ - lists all the available dogs grouped by breed
/dogs/list/{breed} - list all dogs by breed
/dogs/{id} - details of a particular dog picture
/dogs/vote/up/{id}/{client} - votes up a picture
/dogs/vote/down/{id}/{client} - votes down a picture

## JSON Responses
This is the example structure of the JSON Response for all but the voting structure.

```
{ id: '123456', pictureUrl: 'http://dogpic.com/123.jpg', timesFavourited: 10, details : 'Free Form test of the details of the dog breed'}

## Testing
Integration tests are ran : `./gradlew integrationTest`
Unit tests are ran : `./gradlew test`

## Running to Test
If you want to run it so that it auto starts you will need to open two windows and run each command in each window.
`./gradlew -t build` - this will automatically build repeatedly with tests.
`./gradlew -t classes` - this will automatically build repeatedly without tests.
`./gradlew bootRun` - runs the

## Building

```
$ mvn package
```

## Running

```
$ java -jar target/api_interview-0.1.0.jar
```
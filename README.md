# API Challenge

## Dependencies

This project uses Maven for builds.
You need Java 8 installed.

## Endpoints
/dogs/list/ - lists all the available dogs grouped by breed
/dogs/list/{breed} - list all dogs by breed
/dogs/{id} - details of a particular dog picture
/dogs/vote/up/{id} - votes up a picture
/dogs/vote/down/{id} - votes down a picture

## JSON Responses
This is the example structure of the JSON Response for all but the voting structure.

```
{ id: '123456', pictureUrl: 'http://dogpic.com/123.jpg', timesFavourited: 10, details : 'Free Form test of the details of the dog breed'}

## Building

```
$ mvn package
```

## Running

```
$ java -jar target/api_interview-0.1.0.jar
```
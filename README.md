This is a project from Jet Brains Academy course. Project creation was divided into 4 stages. Each stage has a different MVP to objective.

## Stage 1: At this point I've implemented basic GET /seats endpoint. It returns number of rows, columns and all seats from "database".

Response body:
`
{
  "total_rows" : 9,
  "total_columns" : 9,
  "available_seats" : [ {
    "row" : 1,
    "column" : 1
  }, {  
    "row" : 1,
    "column" : 2
  }, {
    "row" : 1,
    "column" : 3
  }, {
    "row" : 1,
    "column" : 4
  },
  ...
  {
    "row" : 9,
    "column" : 8
  }, {
    "row" : 9,
    "column" : 9
  } ]
}
`

## Stage 2: In this step I had to create a POST /purchase mapping for users who want to take seat.
This endpoint accepts applciation/json with row and column value.
If seat is able to take, API will occupy seat and return a ticket with seat row, seat column, and price for a ticket.

`
  {
    "row": 5,
    "column": 7,
    "price": 8
    }
`

If seat is already taken, request will respond with 400 (Bad request) code and return an error.

`
  {
     "error": "The ticket has been already purchased!"
  }
`

If number of row/column is out of bounds it also respond with 400 code, but with different message.

`
  {
     "error": "The number of a row or a column is out of bounds!"
  }
`

## Stage 3: Refactor of /purchase endpoint. It should return UUID token and ticket in single respond.

Request body for /purchase endpoint:
`
{
    "row": 3,
    "column": 4
}
`

Response body:
`
{
    "token": "00ae15f2-1ab6-4a02-a01f-07810b42c0ee",
    "ticket": {
        "row": 1,
        "column": 1,
        "price": 10
    }
}
`

#### Implement /return endpoint, send ticket token to return ticket.

Request body:
`
{
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556"
}
`

If token is correct, then return response body:
`
{
    "ticket": {
        "row": 1,
        "column": 2,
        "price": 10
    }
}
`

If token is expired, produce reponse with 400 code with message:
`
{
    "error": "Wrong token!"
}
`

## Stage 4: Add cinema statistics
Implement the /stats endpoint that will handle GET requests with URL parameters. If the URL parameters contain a password key with a super_secret value, return the movie theatre statistics in the following format:

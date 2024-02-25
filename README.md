This is a project from Jet Brains Adademy course. Project creation was divided into 4 stages. Each stage has a different MVP to objective.

Stage 1:
At this point I've implemented basic GET /seats endpoint. It returns number of rows, columns and all seats from "databse".
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

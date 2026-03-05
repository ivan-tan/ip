# Ashley User Guide

Guide to using my chatbot, Ashley, to keep track of your tasks. Tasks added are stored in `./data/Ashley.txt` and will be reloaded on starting the chatbot.

Notes about command format: Words in `UPPER_CASE` are the parameters to be supplied by the user.

## Adding a Todo 

Adds a simple todo task to the list.

Command: `todo TASK`

Example: `todo read book`

Output: Echoes the task and prints the number of tasks currently in the list. 

```
Ok add liao:
  [T][ ] read book
Now have xxx task(s)
```
where `xxx` represents number of tasks in the list.

## Adding a Deadline

Adds a task with a deadline.

Command: `deadline TASK by DEADLINE`

Example: `deadline do homework by 3pm`

Output: Echoes the task and prints the number of tasks currently in the list.

```
Ok add liao:
  [D][ ] do homework (by: 3pm)
Now have xxx task(s)
```
where `xxx` represents number of tasks in the list.

## Adding an Event

Adds an event with a specified start and end time.

Command: `event TASK from START_TIME to END_TIME`

Example: `event meeting from 3pm to 4pm`

Output: Echoes the task and prints the number of tasks currently in the list.

```
Ok add liao:
  [E][ ] meeting (from: 3pm to: 4pm)
Now have xxx task(s)
```
where `xxx` represents number of tasks in the list.

# Features 
## List tasks

Lists all tasks in a numbered list

Command: `List`

Output: A numbered list of all the tasks in memory.

```
1:[T][ ] read book
2:[D][ ] do homework (by: 3pm)
3:[E][ ] meeting (from: 3pm to: 4pm)
```
## Delete Tasks

Deletes a specified tasks from the list.

Command: `delete NUMBER`
where `NUMBER` corresponds to the ranking of the task on the list.

Example: `delete 1`

Output: Echoes the deleted task and prints the number of tasks remaining in the list. 

```
Ok I remove this task liao:
  [T][ ] read book
Now have xxx task(s)
```
where xxx represents number of tasks left in the list.

## Mark/ Unmark task as done

Marks or unmarks a task as done.

Command: `mark NUMBER` or `unmark NUMBER` where `NUMBER` corresponds to the ranking on the task in the list.

Example: `MARK 1`

Output: Echoes the marked task 
```
Ok mark as done alr:
  [D][X] do homework (by: 3pm)
```

## Find Task
Finds the tasks which contain a specified keyword

Command: `find KEYWORD`

Example: `find meeting`

Output: Lists all the tasks containing the keyword
```
oh i found some tasks with that keyword
1.[E][ ] meeting (from: 3pm to: 4pm)
```

## Exit

Exits the chatbot.

Command: `bye`

Output: `bye ttyl`

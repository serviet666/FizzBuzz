# FizzBuzz API

A REST API that exposes the FizzBuzz game.

## Run the project

### With Maven

```bash
mvn spring-boot:run
```

### With Docker

```bash
docker build -t fizzbuzz .
docker run -p 8080:8080 fizzbuzz
```

The API starts on `http://localhost:8080`.

## API Documentation

Swagger UI is available at `http://localhost:8080/swagger-ui.html` once the application is running.

## Endpoint

### `GET /api/fizzbuzz`

Generates a generic FizzBuzz sequence from `1` to `limit` inclusive.

**Query parameters**

| Parameter | Type     | Default | Description                                      |
|-----------|----------|---------|--------------------------------------------------|
| `int1`    | `int`    | `3`     | First divisor (strictly positive)                |
| `int2`    | `int`    | `5`     | Second divisor (strictly positive)               |
| `limit`   | `int`    | `100`   | Upper bound of the sequence, inclusive (strictly positive) |
| `str1`    | `string` | `Fizz`  | String to display for multiples of `int1`        |
| `str2`    | `string` | `Buzz`  | String to display for multiples of `int2`        |

**Rules**

- If `i` is a multiple of both `int1` and `int2` → `str1 + str2`
- If `i` is a multiple of `int1` only → `str1`
- If `i` is a multiple of `int2` only → `str2`
- Otherwise → the number `i`

Values are comma-separated.

**Example**

```
GET /api/fizzbuzz?int1=3&int2=5&limit=15&str1=Fizz&str2=Buzz
```

```
1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz
```

**Errors**

| Code  | Reason                                              |
|-------|-----------------------------------------------------|
| `400` | A parameter is not of the expected type             |
| `400` | `int1`, `int2` or `limit` is less than or equal to zero |
| `400` | `str1` or `str2` is blank                          |

## Health check

```
GET /actuator/health
```

```json
{ "status": "UP" }
```

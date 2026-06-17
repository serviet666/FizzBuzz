# FizzBuzz API

Une API REST qui expose le jeu du FizzBuzz.

## Lancer le projet

```bash
mvn spring-boot:run
```

L'API démarre sur `http://localhost:8080`.

## Endpoint

### `GET /api/fizzbuzz`

Génère une séquence FizzBuzz générique de `1` à `limit` inclus.

**Paramètres de requête**

| Paramètre | Type     | Défaut | Description                                    |
|-----------|----------|--------|------------------------------------------------|
| `int1`    | `int`    | `3`    | Premier diviseur (strictement positif)         |
| `int2`    | `int`    | `5`    | Second diviseur (strictement positif)          |
| `limit`   | `int`    | `100`  | Limite inclusive de la séquence (strictement positif) |
| `str1`    | `string` | `Fizz` | Chaîne à afficher pour les multiples de `int1` |
| `str2`    | `string` | `Buzz` | Chaîne à afficher pour les multiples de `int2` |

**Règles**

- Si `i` est multiple de `int1` **et** `int2` → `str1 + str2`
- Si `i` est multiple de `int1` seulement → `str1`
- Si `i` est multiple de `int2` seulement → `str2`
- Sinon → le nombre `i`

Les valeurs sont séparées par des virgules.

**Exemple**

```
GET /api/fizzbuzz?int1=3&int2=5&limit=15&str1=Fizz&str2=Buzz
```

```
1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz
```

**Erreurs**

| Code | Raison |
|------|--------|
| `400` | Un paramètre n'est pas du bon type |
| `400` | `int1`, `int2` ou `limit` est inférieur ou égal à zéro |
| `400` | `str1` ou `str2` est vide |

## Health check

```
GET /actuator/health
```

```json
{ "status": "UP" }
```

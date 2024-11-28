## Todo List

## User 엔터티 관련 API

---

1. 회원가입 (POST)

* HTTP: POST
* URL: http://localhost:8080/members
* RequestBody
````
{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "password123"
}
````
* ResponseBody
````
{
    "username": "john_doe",
    "email": "john@example.com",
    "password": "password123"
}
````
---

2. 전체 사용자 정보 조회 (GET)
* HTTP: GET
* URL: http://localhost:8080/members
* RequestBody: none
* ResponseBody

````
[
    {
        "id": 1,
        "username": "john_doe",
        "email": "john@example.com"
    },
    {
        "id": 2,
        "username": "kimyunjin",
        "email": "yunjinkim25@mju.ac.kr"
    }
]
````

---

3. 특정 사용자 정보 조회 (GET)

* HTTP: GET
* URL: http://localhost:8080/members/{name}
* * {name}을 사용자의 username으로 대체
* RequestBody: none
* ResponseBody
````
{
  "id": 1,
  "username": "john_doe",
  "email": "john@example.com"
}
````
---

3. 사용자 정보 업데이트 (Update Member)
* HTTP: PUT
* URL: http://localhost:8080/members/{name}
* RequestBody
````
{
  "username": "john_doe_updated",
  "email": "new_email@example.com"
}
````
* ResponseBody
````
{
    "id": 1,
    "username": "john_doe_updated",
    "email": "new_email@example.com"
}
````
---
4. 전체 사용자 삭제 (DELETE)
* HTTP: DELETE
* URL: http://localhost:8080/members
* RequestBody: none
* ResponseBody: 성공적으로 삭제되면 응답이 204로
---

5. 특정 사용자 삭제 (DELETE)
* HTTP: DELETE
* URL: http://localhost:8080/members/{name}
* * {name}을 사용자의 username으로 대체
* RequestBody: none
* ResponseBody: 성공적으로 삭제되면 응답이 204로
----

## Post 엔터티 관련 API

---

1. 게시글 작성 (POST)
* HTTP: POST
* URL: http://localhost:8080/posts
* RequestBody
````
{
  "title": "My First Post",
  "content": "This is the content of the post.",
  "userId": 1
}
````
* ResponseBody
> 게시글이 생성될 때 마다 자동으로 id가 생성
````
{
    "id": 1,
    "title": "My First Post",
    "content": "This is the content of the post.",
    "userId": 1
}
````
---

2. 전체 게시글 목록 조회 (GET)
* HTTP: GET
* URL: http://localhost:8080/posts
* ResponseBody: none
* RequestBody
````
[
    {
        "id": 1,
        "title": "My First Post",
        "content": "This is the content of the post.",
        "userId": 1
    },
    {
        "id": 2,
        "title": "My 1st Post",
        "content": "This is the content of the post.",
        "userId": 2
    }
]
````
---

3. 특정 게시글 조회 (GET)
* HTTP: GET
* URL: http://localhost:8080/posts/{id}
* * {id} 부분을 조회할 게시글의 ID로 대체
* RequestBody: none
* ResponseBody
````
{
    "id": 2,
    "title": "My 1st Post",
    "content": "This is the content of the post.",
    "userId": 2
}
````
---

4. 게시글 수정 (PUT)
* HTTP: PUT
* URL: http://localhost:8080/posts/{id}
* * {id} 부분을 수정할 게시글의 ID로 대체
* RequestBody
````
{
  "title": "Updated Title",
  "content": "Updated content"
}
````
* ResponseBody
````
{
    "id": 2,
    "title": "Updated Title",
    "content": "Updated content",
    "userId": 2
}
````
---

5. 전체 게시글 삭제 (DELETE)
* HTTP: DELETE
* URL: http://localhost:8080/posts
* RequestBody: none
* ResponseBody: none, 성공적으로 삭제되면 응답이 204로
---

6. 게시글 삭제 (Delete)
* HTTP: DELETE
* URL: http://localhost:8080/posts/{id}
* * {id} 부분을 삭제할 게시글의 ID로 대체
* RequestBody: none
* ResponseBody: none, 성공적으로 삭제되면 응답이 204로
---

## Comment 엔터티 관련 API
* 추가 수정 필요

___

1. 댓글 작성 (POST)
* HTTP: POST
* URL: http://localhost:8080/comments
* Body
````
{
  "postId": 1,
  "content": "This is a comment.",
  "userId": 1
}
// postID에 게시글 ID 입력하면 해당 게시글에 Commnet 추가
````

---

2. 전체 게시글의 Comment 목록 조회 (GET)
* HTTP: GET
* URL: http://localhost:8080/comments
* Body: 없음

3. 특정 게시글의 Comment 목록 조회 (GET)
* HTTP: GET
* URL: http://localhost:8080/posts/{postId}/comments
*  * {postId} 부분을 댓글을 조회할 게시글의 ID로 대체
* Body: 없음
---

4. 특정 Comment 조회 (GET) 
* HTTP: GET
* URL: http://localhost:8080/comments/{commentId}
* * {commentId} 부분을 조회할 댓글의 ID로 대체
* Body: 없음
---

5. 특정 Comment 수정 (PUT)
* HTTP: PUT
* URL: http://localhost:8080/comments/{commentId}
* * {commentId} 부분을 수정할 댓글의 ID로 대체
* Body
````
{
  "content": "Updated comment content"
}

````
---

6. 특정 Comment 삭제 (DELETE)
* HTTP: DELETE
* URL: http://localhost:8080/comments/{commentId}
* Body: 없음
---

7. 모든 댓글 삭제 (DELETE)
* HTTP: DELETE
* URL: http://localhost:8080/comments
* Body: 없음




---
3. 추가 기능 API
* 특정 사용자의 게시글 목록 조회
* * 특정 사용자가 작성한 모든 게시글을 조회하는 기능
* 특정 사용자의 댓글 목록 조회
* * 특정 사용자가 작성한 모든 댓글을 조회하는 기능
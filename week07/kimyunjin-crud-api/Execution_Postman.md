## User 엔터티 관련 API

---

1. 회원가입 (POST)

* HTTP: POST
* URL: http://localhost:8080/members
* Body
````
  {
  "username": "john_doe_updated",
  "email": "new_email@example.com"
}
````
---

2. 사용자 정보 조회 (GET)

* HTTP: GET
* URL: http://localhost:8080/members/{name}
* * {name}을 사용자의 username으로 대체
* Body: none
---

3. 사용자 정보 업데이트 (Update Member)
* HTTP: PUT
* URL: http://localhost:8080/members/{name}
* Body
````
{
  "username": "new_kimyunjin",
  "email": "new_email@example.com",
  "password": "new_password123"
}
````
---

4. 사용자 삭제 (DELETE)
* HTTP: DELETE
* URL: http://localhost:8080/members/{name}
* * {name}을 사용자의 username으로 대체
* Body: none, 성공적으로 삭제되면 응답이 204로

----

## Post 엔터티 관련 API

---

1. 게시글 작성 (POST)
> 게시글이 생성될 때 마다 자동으로 id가 생성
* HTTP: POST
* URL: http://localhost:8080/posts
* Body
````
{
  "title": "My First Post",
  "content": "This is the content of the post.",
  "userId": 1
}
````
---

2. 게시글 목록 조회 (GET)
* HTTP: GET
* URL: http://localhost:8080/posts
* Body: 없음
---

3. 특정 게시글 조회 (GET)
* HTTP: GET
* URL: http://localhost:8080/posts/{id}
* * {id} 부분을 조회할 게시글의 ID로 대체
---

4. 게시글 수정 (PUT)
* HTTP: PUT
* URL: http://localhost:8080/posts/{id}
* * {id} 부분을 수정할 게시글의 ID로 대체
* Body
````
{
  "title": "Updated Title",
  "content": "Updated content"
}
````
---
5. 게시글 삭제 (Delete)
* HTTP: DELETE
* URL: http://localhost:8080/posts/{id}
* * {id} 부분을 삭제할 게시글의 ID로 대체
* Body: 없음
---

6. 전체 게시글 삭제 (DELETE)
* HTTP: DELETE
* URL: http://localhost:8080/posts
* Body: 없음, 성공적으로 삭제되면 응답이 204로

---

## Comment 엔터티 관련 API

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
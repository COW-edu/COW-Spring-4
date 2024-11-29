# 7주차 학습 내용
[회원 가입]
![image](https://github.com/user-attachments/assets/4567cc64-37e5-47ae-84d3-6e7f5b1a181d)

[회원 정보 조회]
![image](https://github.com/user-attachments/assets/0f20d309-692d-4761-a4ad-e2a3230af2d9)

[회원 정보 업데이트]
![image](https://github.com/user-attachments/assets/0b938b74-fb12-47c5-b9d7-973b2cfec06a)

[회원 삭제]
![image](https://github.com/user-attachments/assets/bfd9c80c-513b-4e2b-9527-5f95070a1030)

[게시글 작성]
![image](https://github.com/user-attachments/assets/b455b10b-3726-49f9-800d-80edd05be61e)

[게시글 전체 조회]
![image](https://github.com/user-attachments/assets/6f5a0c81-5df9-4e13-9c02-040065ca01fe)

[게시글 특정 조회]
<첫번째 게시글>
![image](https://github.com/user-attachments/assets/3a9d71d1-afa0-4045-95cc-f1c071a5b183)
<두번째 게시글>
![image](https://github.com/user-attachments/assets/adf89c5a-308c-4bfb-a084-25b8cc1f899c)

[게시글 업데이트]
![image](https://github.com/user-attachments/assets/c59ecc92-374d-4441-a20e-83356367a2f6)
![image](https://github.com/user-attachments/assets/cd936a82-7d85-4c3f-b5fe-84aadbc93e5d)

[게시글 삭제]
![image](https://github.com/user-attachments/assets/c6ca5e79-9117-4427-a968-d70b016dd832)

[커멘트 작성]
![image](https://github.com/user-attachments/assets/9967e6ad-174c-4884-b389-449e7a08bb74)

[고민한점]
1. 현재 내 코드는 테이블을 지워도 기존의 테이블 id 값이 할당 되어 있다
   (ex. 1번 id를 지우고 새로운 id를 추가해도 member_id 가 1이 아닌 2가 할당됨)
   -> 답변을 찾아본 결과 디비에서 뭔가를 해주라는데 정확히 뭐가 이유인지
   모르겠음
2. 커멘트 작성 response가
   {
   "content": "This is a comment.",
   "userId": 1
   }
   제공된 것은 이런 형태이지만 postId 없이 해당 포스트를 찾을 방법을 찾지 못해 결국
   {
   "content": "1 comment.",
   "userId": 2,
   "postId": 1
   }
   이렇게 postId도 받는 리스폰스 바디로 수정해서 작성했다.
3. 처음으로 stream이라는 메소드를 접했다. for문을 사용한다면 별도 작성해야 하는 연산을 '메서드 체이닝'을 통해 한번에 연결하여 코드의 간결성과 가독성을 높여주었다. 여러 예제를 참조하며 이해하려 했지만 아직은 확실히 개념을 숙지하지 못했다. 이 개념을 확실히 이해하고 적용할 수 있다면 기존보다 코드 작성에 더 도움이 될 것 같다.
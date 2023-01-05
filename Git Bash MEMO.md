## git 유저 설정    
#### 1) 현재 위치에서 local 저장소 생성    

```git
$ git init
```

#### 2) 깃환경에서사용자이름, 이메일 지정    

```git bash
$ git config --globla user.name "사용자명"

$ git config --globla user.email "사용자이메일명"
```

#### 3) 깃 상태 확인    

```git bash
$ git status
```
    
- - -
    
## git hub 원격 저장소  
#### 1) 원경 저장소에 연결    

```git bash
$ git remote add origin [github 레포지 주소]
$ git remote add origin [branch 이름]   #없으면 생성됨
```
   
#### 2) 원격 저장소에 연결됐는지 확인    

```git bash
$ git remote -v
````
    
#### 3) local 저장소의 커밋을 "맨 처음" 원격 저장소에 업로드    

```git bash
$ git push -u origin master
````

#### 4) local 저장소의 커밋을 원격 저장소에 업로드 (push)    

```git bash
$ git push
$ git push origin master
````

#### 5) 원격 저장소의 커밋을 local 저장소로 가져오기 (pull)    

```git bash
$ git pull
$ git pull origin master
````

#### 6) 원격 저장소에 [브랜치명]으로 push    

```git bash
$ git push origin [브랜치명]
````

#### 7) 원격 저장소 삭제       

```git bash
$ git remote remove origin
```
    
- - -
       
## Merge   
- master 브랜치와 병합    

```git bash
$ git merge [브랜치명]
$ git merge [브랜치명]  --edit // 병합 후 바로 vi 편집기가 나오면서 커밋 메시지 수정 가능
$ git merge [브랜치명]  --no-edit // 커밋 메시지 수정없이 바로 병합
```

- branch1에 branch2를 병합하는 경우    

```git bash
$ git checkout branch1

$ git merge branch2
```

Already up to date. 가 뜬다면    
branch2로 들어가 pull작업을 해준 후 merge 한다.    

- merge 취소하기   

```git bash
$ git merge --abort
```
   
- - -
    
## branch    
- branch 생성  

```git bash
$ git branch [브랜치명]
```

- 브랜치 조회    

```git bash
$ git branch [브랜치명]
```

- 브랜치변경  

```git bash
$ git checkout [브랜치명]
$ git checkout -b [브랜치명]  --브랜치 만들고 바로 이동
```

- 브랜치 삭제    

```git bash
$ git branch -d [브랜치명]
```
   

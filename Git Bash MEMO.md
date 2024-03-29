## git 유저 설정    
#### 1) 현재 위치에서 local 저장소 생성     


```ruby
$ git init
```

<br>  

#### 2) 깃환경에서사용자이름, 이메일 지정     


```ruby
$ git config --globla user.name "사용자명"

$ git config --globla user.email "사용자이메일명"
```

<br>  

#### 3) 깃 상태 확인      


```ruby
$ git status
```
  

- - -

<br>   

## git hub 원격 저장소  
#### 1) 원경 저장소에 연결    


```ruby
$ git remote add origin [github 레포지 주소]
$ git remote add origin [branch 이름]   #없으면 생성됨
```

<br>   

#### 2) 원격 저장소에 연결됐는지 확인    


```ruby
$ git remote -v
````

   
<br>

#### 3) local 저장소의 커밋을 <u>맨 처음</u> 원격 저장소에 업로드    

```ruby
$ git push -u origin master
````

<br>

#### 4) local 저장소의 커밋을 원격 저장소에 업로드 (push)    

```ruby
$ git push
$ git push origin master
````

<br>  

#### 5) 원격 저장소의 커밋을 local 저장소로 가져오기 (pull)    

```ruby
$ git pull
$ git pull origin master
````

<br>  

#### 6) 원격 저장소에 [브랜치명]으로 push    

```ruby
$ git push origin [브랜치명]
````

<br>  

#### 7) 원격 저장소 삭제       

```ruby
$ git remote remove origin
```
   

- - -

<br>  

## Merge   
- master 브랜치와 병합    

```ruby
$ git merge [브랜치명]
$ git merge [브랜치명]  --edit     # 병합 후 바로 vi 편집기가 나오면서 커밋 메시지 수정 가능
$ git merge [브랜치명]  --no-edit  # 커밋 메시지 수정없이 바로 병합
```

<br>  

- branch1에 branch2를 병합하는 경우    

```ruby
$ git checkout branch1

$ git merge branch2
```

Already up to date. 가 뜬다면    
branch2로 들어가 pull작업을 해준 후 merge 한다.    

<br>  

- merge 취소하기   

```ruby
$ git merge --abort
```
 

- - -

<br>  

## branch    
- branch 생성  

```ruby
$ git branch [브랜치명]
```

<br>  

- 브랜치 조회    

```ruby
$ git branch [브랜치명]
```

<br>  

- 브랜치변경  

```ruby
$ git checkout [브랜치명]
$ git checkout -b [브랜치명]  # 브랜치 만들고 바로 이동
```

<br>  

- 브랜치 삭제    

```ruby
$ git branch -d [브랜치명]
```
   

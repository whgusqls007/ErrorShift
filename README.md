**에러핸들러를 제공해주는 SpringBoot 라이브러리**

<aside>
💬 초보 웹 개발자를 위한 OpenSource 라이브러리로, `어노테이션`으로 에러핸들러를 쉽게 제공해 줍니다. RestAPI 요청시 발생하는 HTTP 에러에 대해 응답을 `커스텀` 할 수 있습니다.

</aside>
</br>
<aside>
💡 싸피 교육생 또는 초보 개발자를 위한 에러핸들러로, 기본 에러 내용의 복잡함을 보다 가독성 있게 바꿔줌과 동시에 에러핸들러를 직접 제작하는 시간적, 인적 비용을 최소화 하기 위해 서비스를 기획하였습니다.

</aside>
</br>
<aside>
👉 SpringBoot의 에러 처리로직을 공부하고 에러핸들러 및 커스텀 어노테이션 제작등 라이브러리 제작을 담당하였습니다.

</aside>

**어려웠던 점 및 배운 점**

<aside>
💬 초기에는 Lombok형태로 에러핸들러를 제공하고자 했습니다. Lombok은 Compiler Tree API를 사용해 Compile타임에 어노테이션을 스캔하여 Annotation Processor의 동작에 따라 Systax tree에 class파일을 추가시켜줍니다. 하지만 실제 코드를 작성하는 단계에선 존재하지 않는 내용이기 때문에 에러가 나게 되고, 이를 JAVA IDE에서는 확장 프로그램, 플러그인 등으로 처리를 해 줍니다. 이러한 플러그인을 제작하는데 실력과 시간적 한계가 존재하였고, BasicErrorController, DefaultErrorAttribute를 재 정의 하고 ImportAware 인터페이스를 사용해 구현을 하며, SpringBoot의 에러 처리의 전반적인 부분을 공부 하였습니다.

</aside>

# ErrorShift
When you work in spring boot project, "ErrorSfhit" can support your error handling.

## Usage
#### Annotation property
|Name|Value|
|---|---|
|exception|Exception class to apply error handling|
|language|"en" or "ko"|
|prettyRes|"true" or "false"|
|message|Custom exception message|
|userResPackage|User custom response to the exception|
|logging|"true" or "false"|
|httpStatus|Http status of exception|
|trace|"true" or "false"|

## Start
Choose one of the following.
#### Maven (Not valid)
Add the following dependency to your project.
```
<groupId>com.ssafy</groupId>
<artifactId>e206</artifactId>
<version>1.0.0</version>
```
#### Gradle (Not valid)
Add the following dependency to your project.
```
implementation group: 'com.ssafy', name: 'e206', version '1.0.0'

```
or
```
implementation 'com.ssafy:e206:1.0.0'
```
#### External jar file
<a href="https://errorshift.com/file/download">e206-1.0.0.jar</a>

#### Release history ?
- 1.0.0

## Contributing
1. Fork git repository from the original reporitory
2. Up-to-date your forked repository
3. Create branch for work in your repository
4. Commit and push in your repository
5. Pull request to the original reporitory

## License
    MIT License

    Copyright (c) 2022 errorshift

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.


## Contributors
|<a href="https://lab.ssafy.com/kmc0968"><img src="https://secure.gravatar.com/avatar/b2abb1400f90f92811ed39b389434a34?s=100&d=identicon" /></a>|<a href="https://lab.ssafy.com/dbehrud9323"><img src="https://secure.gravatar.com/avatar/c3014443fd84a4ba56bc28cc1ac0d062?s=100&d=identicon" /></a>|<a href="https://lab.ssafy.com/sumin9366"><img src="https://secure.gravatar.com/avatar/a93784a47970b21d1ebd02b164b5fb29?s=100&d=identicon" /></a>|<a href="https://lab.ssafy.com/david9696"><img src="https://secure.gravatar.com/avatar/95a9df67a7316e6cdbb7ecf14366652a?s=100&d=identicon" /></a>|<a href="https://lab.ssafy.com/jo7hb"><img src="https://secure.gravatar.com/avatar/afaccdd3e6263b09de5e397f94e1a820?s=100&d=identicon" /></a>|<a href="https://lab.ssafy.com/goldflowed"><img src="https://secure.gravatar.com/avatar/259b86dbdaef5dd247648d88eff8d0dc?s=100&d=identicon" /></a>|
|---|---|---|---|---|---|
|Mincheol Kim|Dokyeong Yu|Sumin Lee|Wonseok Jang|Hyunbin Jo|Yuri Kim|


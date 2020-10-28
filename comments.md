### 完成度：
+ 需求基本实现，仅有些bug

__Details:__

- \- Resource.java:30 缺少组名
- \- Resource.java:37 当组员为0的时候，分组接口会报错，500

### 知识点：
* API设计不符合restful规范
* 如果不是特定的自定义返回结果，ResponseEntity可以省略
* 了解下lombok
* 了解下三层架构

__Details:__

- \- Resource.java:35 按照restful规范，这里应该是一个POST请求
- \- Resource.java:43 按照restful规范，这里应该是一个POST请求
- \- DivideStudentService.java:13 数据存储相关的操作，不属于service的职责，应该抽取repository层做

### 工程实践：
* Resource.java:14 一般项目上（使用了常规三层架构），在controller这一层class的命名，以xxxController命名。如果是用了其他必须要按照特定规则命名框架，那就按照项目要求来。

__Details:__

- \- Resource.java:22 path应该首字母小写
- \- Resource.java:41 变量名应该是驼峰，首字母小写
- \- DivideStudentService.java:51 长方法，需要分模块抽取方法，进行重构
- \- DivideStudentService.java:56 Magic number
- \- DivideStudentService.java:58 命名不表意，且变量名应该是驼峰形式





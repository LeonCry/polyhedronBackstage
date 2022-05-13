# polyhedronBackstage

polyhedronBackstage


## 使用
### 1.JSONObject

- 一般是接收到的前端传来的JSON,在后端我们需要将其序列化为JavaBean,序列化方法:


    ContentValue contentValue = JSON.parse(s, ContentValue.class);


s为接收到的前端JSON,contentValue为JavaBean对象.

- 修改完之后,反序列化传回去:


    String content = JSON.toJSONString(contentValue);


- JSON对象(JSONObject)中的数据都是以key-value形式出现，所以它实现了Map接口：

方法:

    getString(String k):取出 key为k的value值

    remove(Object k): 将 key 为 k 的键值对移除







### 2.JSONArray

JSONArray则是JSON数组，JSON数组对象中存储的是一个个JSON对象，所以类中的方法主要用于直接操作JSON对象

方法:

    getJSONObject(int index):取出 index 索引下的JSON对象



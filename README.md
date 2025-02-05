## radp-desensitization

## QuickStart

### 第一步 引入依赖

- 方式一:

```xml
<dependency>
    <groupId>space.x9x.solutions</groupId>
    <artifactId>radp-desensitization-sdk</artifactId>
    <version>最新版本</version>
</dependency>
```

- 方式二

```xml
<dependency>
    <groupId>space.x9x.solutions</groupId>
    <artifactId>radp-desensitization-sdk-starter</artifactId>
    <version>最新版本</version>
</dependency>
```

### 配置 SDK

```yaml
radp:
  desensitization:
    # SDK运行模式, FETCH/OFFLINE
    mode: FETCH
    config:
      # 系统编号
      system_id: xxx
      config_address: http://ip:port
      # 本地缓存刷新时间(多久去远程拉取最新规则), 单位: 秒
      refresh_after_write: 3600
      # 本地缓存过期时间, 单位: 秒
      expire_after_write: 86400
```


### 使用

省略
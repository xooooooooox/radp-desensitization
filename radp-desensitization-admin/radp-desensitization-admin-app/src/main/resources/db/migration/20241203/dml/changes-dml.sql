INSERT INTO desensitization_rule_config (system_id, rule_id, disable, rule_type, rule_key, rule_value, rule_desc)
VALUES
    ('x9x-demo','10001','','REGEX', 'regexDesensitize', '{"regex":"^[\s\S]*$","replacer":"*"}', '正则脱敏规则'),
    ('x9x-demo','10002','','REGEX', 'emailDesensitize', '{"regex":"(^.)[^@]*(@.*$)","replacer":"*"}', '邮箱脱敏规则'),
    ('x9x-demo','10003','','SLIDER', 'sliderDesensitize', '{"prefixKeep":0,"suffixKeep":0,"replacer":"*"}', '滑块脱敏规则'),
    ('x9x-demo','10004','','SLIDER', 'bankCardDesensitize', '{"prefixKeep":6,"suffixKeep":2,"replacer":"*"}', '卡号脱敏规则'),
    ('x9x-demo','10005','','SLIDER', 'carLicenseDesensitize', '{"prefixKeep":3,"suffixKeep":1,"replacer":"*"}', '车牌号脱敏规则'),
    ('x9x-demo','10006','','SLIDER', 'chineseNameDesensitize', '{"prefixKeep":1,"suffixKeep":0,"replacer":"*"}', '中文姓名脱敏规则'),
    ('x9x-demo','10007','','SLIDER', 'fixedPhoneDesensitize', '{"prefixKeep":4,"suffixKeep":2,"replacer":"*"}', '固定电话脱敏规则'),
    ('x9x-demo','10008','','SLIDER', 'idCardDesensitize', '{"prefixKeep":6,"suffixKeep":2,"replacer":"*"}', '身份证号脱敏规则'),
    ('x9x-demo','10009','','SLIDER', 'mobileDesensitize', '{"prefixKeep":3,"suffixKeep":4,"replacer":"*"}', '手机号脱敏规则'),
    ('x9x-demo','10010','','SLIDER', 'passwordDesensitize', '{"prefixKeep":0,"suffixKeep":0,"replacer":"*"}', '密码脱敏规则');
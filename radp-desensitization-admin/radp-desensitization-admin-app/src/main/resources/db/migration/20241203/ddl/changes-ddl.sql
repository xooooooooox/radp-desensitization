CREATE TABLE desensitization_rule_config
(
    id                 BIGINT(11)   NOT NULL AUTO_INCREMENT COMMENT '自增 ID',
    system_id          VARCHAR(16)  NOT NULL COMMENT '系统编号',
    rule_id            VARCHAR(16)  NOT NULL COMMENT '脱敏编号',
    rule_type          VARCHAR(8)   NOT NULL COMMENT '脱敏类型(0-regex, 1-slider)',
    rule_key           VARCHAR(32)  NOT NULL COMMENT '脱敏规则 key',
    rule_value         VARCHAR(128) NOT NULL COMMENT '脱敏规则 value',
    rule_desc          VARCHAR(64)  NOT NULL COMMENT '脱敏规则描述',
    disable            VARCHAR(64)  NOT NULL COMMENT '是否禁用脱敏,支持SpEL表达式',
    created_date       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    last_modified_date DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (id),
    UNIQUE KEY uq_rule_key (rule_key)
) COMMENT '脱敏规则配置表';
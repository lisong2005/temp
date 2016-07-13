/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2016/4/14 15:22:39                           */
/*==============================================================*/


drop table if exists eh_config_param;

drop table if exists eh_open_token;

drop table if exists eh_wx_event;

drop table if exists eh_wx_user;

drop table if exists test_pay_order;

/*==============================================================*/
/* Table: eh_config_param                                       */
/*==============================================================*/
create table eh_config_param (
   id                   bigint               not null,
   system_name          text                 null,
   module_name          text                 null,
   param_key            text                 null,
   param_value          text                 null,
   status               text                 null,
   memo                 text                 null,
   gmt_create           TIMESTAMP WITH TIME ZONE null,
   gmt_modify           TIMESTAMP WITH TIME ZONE null,
   constraint pk_eh_config_param primary key (id),
   constraint uk_eh_config_param_smk unique (system_name, module_name, param_key)
);

comment on table eh_config_param is
'配置参数表';

comment on column eh_config_param.id is
'数据库seq';

comment on column eh_config_param.system_name is
'系统名';

comment on column eh_config_param.module_name is
'模块名';

comment on column eh_config_param.param_key is
'参数key';

comment on column eh_config_param.param_value is
'参数值';

comment on column eh_config_param.status is
'状态：E可用；D不可用';

comment on column eh_config_param.memo is
'备注';

comment on column eh_config_param.gmt_create is
'创建时间';

comment on column eh_config_param.gmt_modify is
'最近修改时间';

/*==============================================================*/
/* Table: eh_open_token                                         */
/*==============================================================*/
create table eh_open_token (
   id                   bigint               not null,
   app_type             text                 null,
   app_id               text                 null,
   access_token         text                 null,
   refresh_token        text                 null,
   props                text                 null,
   memo                 text                 null,
   gmt_create           TIMESTAMP WITH TIME ZONE null,
   gmt_modify           TIMESTAMP WITH TIME ZONE null,
   gmt_effect           TIMESTAMP WITH TIME ZONE null,
   gmt_expire           TIMESTAMP WITH TIME ZONE null,
   constraint pk_eh_open_token primary key (id)
);

comment on column eh_open_token.id is
'数据库seq';

comment on column eh_open_token.app_type is
'应用类型：weixin；...';

comment on column eh_open_token.app_id is
'应用ID';

comment on column eh_open_token.access_token is
'访问令牌';

comment on column eh_open_token.refresh_token is
'刷新令牌';

comment on column eh_open_token.props is
'属性：json格式';

comment on column eh_open_token.memo is
'备注';

comment on column eh_open_token.gmt_create is
'创建时间';

comment on column eh_open_token.gmt_modify is
'最近修改时间';

comment on column eh_open_token.gmt_effect is
'生效时间';

comment on column eh_open_token.gmt_expire is
'失效时间';

/*==============================================================*/
/* Table: eh_wx_event                                           */
/*==============================================================*/
create table eh_wx_event (
   id                   bigint               not null,
   to_user              text                 null,
   from_user            text                 null,
   event_type           text                 null,
   event_key            text                 null,
   event_props          text                 null,
   gmt_upload           TIMESTAMP WITH TIME ZONE null,
   gmt_create           TIMESTAMP WITH TIME ZONE null,
   gmt_modify           TIMESTAMP WITH TIME ZONE null,
   constraint pk_eh_wx_event primary key (id)
);

comment on column eh_wx_event.id is
'数据库seq';

comment on column eh_wx_event.to_user is
'消息接收者';

comment on column eh_wx_event.from_user is
'消息发送者';

comment on column eh_wx_event.event_type is
'事件类型';

comment on column eh_wx_event.event_key is
'事件码';

comment on column eh_wx_event.event_props is
'时间属性：json格式';

comment on column eh_wx_event.gmt_upload is
'提交时间';

comment on column eh_wx_event.gmt_create is
'创建时间';

comment on column eh_wx_event.gmt_modify is
'最近修改时间';

/*==============================================================*/
/* Table: eh_wx_user                                            */
/*==============================================================*/
create table eh_wx_user (
   id                   bigint               not null,
   app_id               text                 null,
   open_id              text                 null,
   union_id             text                 null,
   props                text                 null,
   gmt_create           TIMESTAMP WITH TIME ZONE null,
   gmt_modify           TIMESTAMP WITH TIME ZONE null,
   constraint pk_eh_weixin_user primary key (id),
   constraint uk_eh_weixin_user_aoid unique (app_id, open_id)
);

comment on column eh_wx_user.id is
'数据库seq';

comment on column eh_wx_user.app_id is
'应用ID';

comment on column eh_wx_user.open_id is
'openId';

comment on column eh_wx_user.union_id is
'unionId';

comment on column eh_wx_user.props is
'其他属性';

comment on column eh_wx_user.gmt_create is
'创建时间';

comment on column eh_wx_user.gmt_modify is
'最近修改时间';

/*==============================================================*/
/* Table: test_pay_order                                        */
/*==============================================================*/
create table test_pay_order (
   id                   bigint               not null,
   trade_no             text                 null,
   amount               bigint               not null,
   memo                 text                 null,
   constraint pk_xy_ztc_pay_order primary key (id)
);


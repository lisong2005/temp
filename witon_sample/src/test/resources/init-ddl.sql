/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2016/4/14 12:43:20                           */
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
   gmt_create           timestamp            null,
   gmt_modify           timestamp            null,
   constraint pk_eh_config_param primary key (id),
   constraint uk_eh_config_param_smk unique (system_name, module_name, param_key)
);

comment on table eh_config_param is
'���ò�����';

comment on column eh_config_param.id is
'���ݿ�seq';

comment on column eh_config_param.system_name is
'ϵͳ��';

comment on column eh_config_param.module_name is
'ģ����';

comment on column eh_config_param.param_key is
'����key';

comment on column eh_config_param.param_value is
'����ֵ';

comment on column eh_config_param.status is
'״̬��E���ã�D������';

comment on column eh_config_param.memo is
'��ע';

comment on column eh_config_param.gmt_create is
'����ʱ��';

comment on column eh_config_param.gmt_modify is
'����޸�ʱ��';

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
   gmt_create           timestamp            null,
   gmt_modify           timestamp            null,
   gmt_effect           timestamp            null,
   gmt_expire           timestamp            null,
   constraint pk_eh_open_token primary key (id)
);

comment on column eh_open_token.id is
'���ݿ�seq';

comment on column eh_open_token.app_type is
'Ӧ�����ͣ�weixin��...';

comment on column eh_open_token.app_id is
'Ӧ��ID';

comment on column eh_open_token.access_token is
'��������';

comment on column eh_open_token.refresh_token is
'ˢ������';

comment on column eh_open_token.props is
'���ԣ�json��ʽ';

comment on column eh_open_token.memo is
'��ע';

comment on column eh_open_token.gmt_create is
'����ʱ��';

comment on column eh_open_token.gmt_modify is
'����޸�ʱ��';

comment on column eh_open_token.gmt_effect is
'��Чʱ��';

comment on column eh_open_token.gmt_expire is
'ʧЧʱ��';

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
   gmt_upload           timestamp            null,
   gmt_create           timestamp            null,
   gmt_modify           timestamp            null,
   constraint pk_eh_wx_event primary key (id)
);

comment on column eh_wx_event.id is
'���ݿ�seq';

comment on column eh_wx_event.to_user is
'��Ϣ������';

comment on column eh_wx_event.from_user is
'��Ϣ������';

comment on column eh_wx_event.event_type is
'�¼�����';

comment on column eh_wx_event.event_key is
'�¼���';

comment on column eh_wx_event.event_props is
'ʱ�����ԣ�json��ʽ';

comment on column eh_wx_event.gmt_upload is
'�ύʱ��';

comment on column eh_wx_event.gmt_create is
'����ʱ��';

comment on column eh_wx_event.gmt_modify is
'����޸�ʱ��';

/*==============================================================*/
/* Table: eh_wx_user                                            */
/*==============================================================*/
create table eh_wx_user (
   id                   bigint               not null,
   app_id               text                 null,
   open_id              text                 null,
   union_id             text                 null,
   props                text                 null,
   gmt_create           timestamp            null,
   gmt_modify           timestamp            null,
   constraint pk_eh_weixin_user primary key (id),
   constraint uk_eh_weixin_user_aoid unique (app_id, open_id)
);

comment on column eh_wx_user.id is
'���ݿ�seq';

comment on column eh_wx_user.app_id is
'Ӧ��ID';

comment on column eh_wx_user.open_id is
'openId';

comment on column eh_wx_user.union_id is
'unionId';

comment on column eh_wx_user.props is
'��������';

comment on column eh_wx_user.gmt_create is
'����ʱ��';

comment on column eh_wx_user.gmt_modify is
'����޸�ʱ��';

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


CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goods_type` int(11) DEFAULT NULL COMMENT '商品所属类型id，取值表goods_type的id',
  `goods_name` varchar(120) NOT NULL COMMENT '商品的名称',
  `goods_desc` text COMMENT '商品描述',
  `goods_sn` varchar(60) NOT NULL COMMENT '商品的唯一货号',
  `goods_number` int(11) DEFAULT '0' COMMENT '商品库存数量',
  `click_count` int(11) DEFAULT '0' COMMENT '商品点击数',
  `market_price` int(11) DEFAULT NULL COMMENT '市场售价',
  `promote_price` int(11) DEFAULT NULL COMMENT '促销价格',
  `promote_start_date` datetime DEFAULT NULL COMMENT '促销价格开始日期',
  `promote_end_date` datetime DEFAULT NULL COMMENT '促销价格结束日期',
  `goods_img` varchar(500) DEFAULT NULL COMMENT '商品的实际大小图片，如进入该商品页时介绍商品属性所显示的大图片',
  `keywords` varchar(500) DEFAULT NULL COMMENT '商品关键字，放在商品页的关键字中，为搜索引擎收录用',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺id',
  `create_time` datetime DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  `is_delete` enum('N','Y') DEFAULT 'N' COMMENT '是否已删除，N否,Y是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

CREATE TABLE `goods_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类id',
  `cat_name` varchar(90) NOT NULL COMMENT '分类名称',
  `cat_desc` varchar(255) DEFAULT NULL COMMENT '分类描述',
  `keywords` varchar(255) DEFAULT NULL COMMENT '分类的关键字,可能是为了搜索',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '该分类的父类ID,取值于该表的id字段',
  `sort_order` int(11) DEFAULT NULL COMMENT '该分类在页面显示的顺序,数字越大顺序越靠后,同数字,id在前的先显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分类表';

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(60) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `sex` enum('U','F','M') DEFAULT 'U' COMMENT '性别,U("保密"),M("男"),F("女")',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `qq` varchar(20) DEFAULT NULL,
  `weixin` varchar(20) DEFAULT NULL COMMENT '微信号',
  `email` varchar(60) DEFAULT NULL COMMENT '邮箱',
  `last_login` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  `last_update` datetime DEFAULT NULL COMMENT '应该是最后一次修改信息时间，该信息可以从其他表同步过来',
  `address_id` int(11) DEFAULT NULL COMMENT '收货信息id,表值表user_address',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `collect_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏记录的自增id',
  `user_id` int(11) DEFAULT NULL COMMENT '该条收藏记录的会员id，取值于users的user_id',
  `goods_id` int(11) DEFAULT NULL COMMENT '收藏的商品id，取值于goods的goods_id',
  `add_time` datetime DEFAULT NULL COMMENT '收藏时间',
  `is_attention` enum('N','Y') DEFAULT 'N' COMMENT '是否关注该收藏商品',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员收藏商品的记录列表，一条记录一个收藏商品';


package com.example.community.dto;

import lombok.Data;

import java.security.PrivateKey;

//Data transfer object
/*
在分布式系统中，客户端和服务器端交互有两种情形：第一个是客户端从服务器端读取数据；第二个是客户端将本身的数据传递给服务器端。

当有客户端要向服务器端传输大量数据的时候，可以通过一个包含要传输的所有数据的方法调用来完成。这在小数据量的时候缺点并不明显，但是如果要传递包含有大量信息的数据的时候，这将变得难以忍受。下面的方法是任何人看了都会害怕的：

public void save(String id,String number,String name,int type,int height,

int width,BigDecimal weight,BigDecimal price,String description)

这种接口也是非常的脆弱，一旦需要添加或者删除某个属性，方法的签名就要改变。

当客户端要从服务器端取得大量数据的时候，可以使用多个细粒度的对服务器端的调用来获取数据。比如：

ISomeInterface intf = RemoteService.getSomeInterface();

System.out.println("您要查询的商品的资料为:");

System.out.println("编号："+intf.getNumber(id));

System.out.println("姓名："+intf.getName(id));

System.out.println("类型："+intf.getType(id));

System.out.println("高度："+intf.getHeight(id));

System.out.println("宽度："+intf.getWidth(id));

System.out.println("价格："+intf.getPrice(id));

System.out.println("描述信息："+intf.getDescription(id));

这种方式中每一个get***方法都是一个对服务器 的远程调用，都需要对参数和返回值进行序列化和反序列化，而且服务器进行这些调用的时候还需要进行事务、权限、日志的处理，这会造成性能的大幅下降。如果 没有使用客户端事务的话还会导致这些调用不在一个事务中从而导致数据错误。

系统需要一种在客户端和服务器端之间高效、安全地进 行数据传输的技术。DTO(Data Transfer Object，数据传送对象)是解决这个问题的比较好的方式。DTO是一个普通的Java类，它封装了要传送的批量的数据。当客户端需要读取服务器端的数 据的时候，服务器端将数据封装在DTO中，这样客户端就可以在一个网络调用中获得它需要的所有数据。

还是上面的例子，服务器端的服务将创建一个DTO并封装客户端所需要的属性，然后返回给客户端：

ISomeInterface intf = RemoteService.getSomeInterface();

SomeDTOInfo info = intf.getSomeData(id);

System.out.println("您要查询的商品的资料为:");

System.out.println("编号："+info.getNumber());

System.out.println("姓名："+info.getName());

System.out.println("类型："+info.getType());

System.out.println("高度："+info.getHeight());

System.out.println("宽度："+info.getWidth());

System.out.println("价格："+info.getPrice());

System.out.println("描述信息："+info.getDescription());
*
* */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}

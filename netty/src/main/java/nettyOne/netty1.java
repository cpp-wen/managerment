package nettyOne;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @description:
 * @author:maidang
 * @date:2021/04/18
 **/
public class netty1 {
  public static void main(String[] args) throws Exception {
    int port;
    if (args.length > 0) {
      port = Integer.parseInt(args[0]);
    } else {
      port = 8069;
    }
    new DiscardServer(port).run();
  }
}

class DiscardServer {

  private int port;

  public DiscardServer(int port) {
    this.port = port;
  }

  public void run() throws Exception {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workGrou = new NioEventLoopGroup();
    try {
      ServerBootstrap b=new ServerBootstrap();
      b.group(bossGroup, workGrou)
          .channel(NioServerSocketChannel.class)
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
              socketChannel.pipeline().addLast(new DiscardServerHandler());
            }
          })
          .option(ChannelOption.SO_BACKLOG,128)
          .childOption(ChannelOption.SO_KEEPALIVE,true);
          ChannelFuture f=b.bind(port).sync();
          f.channel().closeFuture().sync();
    }finally {
      bossGroup.shutdownGracefully();
      workGrou.shutdownGracefully();
    }
  }
}

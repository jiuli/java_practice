package java_io;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;

/**
 * NettyTest
 * 为什么有netty，首要原因就是：nio使用起来太麻烦
 * netty保留的nio的特性，进行了封装优化
 *
 * @author lijunsong
 * @date 2021/5/25 18:39
 * @since 1.0
 */
@Slf4j
public class NettyTest {
    public void start(int port) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        //主线程
        EventLoopGroup masterGroup = new NioEventLoopGroup();
        //从线程
        EventLoopGroup salveGroup = new NioEventLoopGroup();
        try {
//            bootstrap.group(masterGroup, salveGroup)
//                    //主线程监听Channel
//                    .channel(NioServerSocketChannel.class)
//                    .option(ChannelOption.SO_BACKLOG, 1024)
//                    //定义从线程的handler链，责任链模式
//                    .childHandler(new ChannelInitializer<SocketChannel>() {
//
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new NettyServerHandler());
//                        }
//                    });
            ChannelFuture future = bootstrap.bind(port).sync();

            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            masterGroup.shutdownGracefully();
            salveGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {

    }
}

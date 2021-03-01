package top.jzhp.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {


    public static void main(String[] args) {

        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(8080))
                    /*
                     * 注册ChannelHandler
                     *
                     */
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {

                        }
                    })
                    /*
                     * ServerBootStrap 设置的Channel属性有option和childOption两个方法
                     * + option      -> 负责设置Boss线程组
                     * + childOption -> 负责设置worker线程组
                     *
                     * 经常使用的设置参数如下：
                     * SO_KEEPALIVE	     设置为 true 代表启用了 TCP SO_KEEPALIVE 属性，TCP 会主动探测连接状态，即连接保活
                     * SO_BACKLOG	     已完成三次握手的请求队列最大长度，同一时刻服务端可能会处理多个连接，在高并发海量连接的场景下，该参数应适当调大
                     * TCP_NODELAY	     Netty 默认是 true，表示立即发送数据。如果设置为 false 表示启用 Nagle 算法，该算法会将 TCP 网络数据包累积到一定量才会发送，虽然可以减少报文发送的数量，但是会造成一定的数据延迟。Netty 为了最小化数据传输的延迟，默认禁用了 Nagle 算法
                     * SO_SNDBUF	     TCP 数据发送缓冲区大小
                     * SO_RCVBUF	     TCP数据接收缓冲区大小，TCP数据接收缓冲区大小
                     * SO_LINGER	     设置延迟关闭的时间，等待缓冲区中的数据发送完成
                     * CONNECT_TIMEOUT_MILLIS	建立连接的超时时间
                     */
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            /*
             * bind() 真正启动触发
             * sync() 会阻塞，直至整个启动过程完成
             */
            final ChannelFuture sync = bootstrap.bind().sync();
            sync.channel().closeFuture().sync();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }
}

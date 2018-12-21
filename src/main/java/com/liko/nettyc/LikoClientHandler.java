package com.liko.nettyc;

import com.liko.nettyc.message.RequestMsg;
import com.liko.nettyc.message.ResponseMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by likoguan on 6/12/18.
 */
public class LikoClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        RequestMsg requestMsg = new RequestMsg();
        requestMsg.setNo(1);
        ctx.writeAndFlush(requestMsg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf msgBuf = (ByteBuf) msg;
//        try {
//            int length = msgBuf.readableBytes();
//            if (length > 0) {
//                byte[] content = new byte[length];
//                msgBuf.readBytes(content);
//                System.out.println(new String(content));
//            }
////            ctx.close();
//        } finally {
//            msgBuf.release();
//        }
        ResponseMsg responseMsg = (ResponseMsg) msg;
        System.out.println(responseMsg.toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}

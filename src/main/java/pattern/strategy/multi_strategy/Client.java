package pattern.strategy.multi_strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/27 13:07
 * @since 1.0
 */
@Slf4j
public class Client {
    /**
     * 一般策略模式同一时刻只能执行一种策略
     * 这个跟上下文有关，如：如果只要结果，不管执行一种还是多种策略
     * 这三个计策都是取西川的计策，也就是攻取西川这个问题的具体的策略算法，
     * 刘备可以采用上策，可以采用中策，当然也可以采用下策，由此可见策略模式的各种具体的策略算法都是平等的，可以相互替换。
     * <p>
     * 　　那谁来选择具体采用哪种计策（算法）？
     * <p>
     * 在这个故事中当然是刘备选择了，也就是外部的客户端选择使用某个具体的算法，然后把该算法（计策）设置到上下文当中；
     * <p>
     * 还有一种情况就是客户端不选择具体的算法，把这个事交给上下文，这相当于刘备说我不管有哪些攻取西川的计策，
     * 我只要结果（成功的拿下西川），具体怎么攻占（有哪些计策，怎么选择）由参谋部来决定（上下文）。
     */
    public static void main(String[] args) {
        OccupationContext context = new OccupationContext();
        //这个给手下的人激励不够啊,上上策失败
        context.occupationWestOfXiChuan("拿下西川");
        //这个人人有赏，让士兵有动力啊
        context.occupationWestOfXiChuan("拿下西川之后，人人有赏！");
    }
}

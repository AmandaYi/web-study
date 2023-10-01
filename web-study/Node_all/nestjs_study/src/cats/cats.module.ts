import { Module, Global } from '@nestjs/common';
import { CatsController } from './cats.controller';
import { CatsService } from './cats.service';




@Global() // 如果愿意,那么就把cat.module存放到全局
@Module({
    imports:[],// 导入别人的模块,相当于高级组件HOC
    controllers:[CatsController],
    providers:[CatsService],
    // 共享自身的服务
    exports:[CatsService]
})
export class CatsModule {}

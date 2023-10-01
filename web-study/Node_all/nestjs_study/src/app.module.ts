import { Module, NestModule, MiddlewareConsumer, RequestMethod } from '@nestjs/common';

import { LoggerMiddleware } from './common/middleware/logger.middleware';

import { AppController } from './app.controller';
import { AppService } from './app.service';
import { CatsController } from './cats/cats.controller';
import { CatsService } from './cats/cats.service';
import { CatsModule } from './cats/cats.module';
import { DatabaseModule } from './database/database.module';

@Module({
  imports: [CatsModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule implements NestModule {
  configure(consumer: MiddlewareConsumer): void | MiddlewareConsumer {
    consumer
      // .apply(LoggerMiddleware)
      .apply(logger)
      // consumer.apply(cors(), helmet(), logger).forRoutes(CatsController);
      // .forRoutes({
      //   path: "cats",
      //   method: RequestMethod.GET
      // });
      .exclude(
        { path: 'cats', method: RequestMethod.GET },
        { path: 'cats', method: RequestMethod.POST }
      )
      .forRoutes(CatsController);
  }


}

function logger(req, res, next) {
  console.log(`Request...`);
  next();
};
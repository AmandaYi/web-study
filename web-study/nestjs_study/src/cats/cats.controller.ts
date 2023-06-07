import { Controller, Get, Req, HttpCode, Post, Header, Param, Body } from '@nestjs/common';
import { Request } from "express"
import { Observable, of } from 'rxjs';
import { CreateCatDto } from './dto/cat.dto';
import { CatsService } from './cats.service';
import { Cat } from './interface/cat.interface';
@Controller('cats')
export class CatsController {
    constructor (private readonly catsService:CatsService){}
    /**
     * 
     * 基础RES方式的书写
     * 
     * 
     */
    // @Get("ab*ba")
    // findAll(@Req() request: Request): string {
    //     return 'This action returns all cats1';
    // }
    // @Post()
    // @HttpCode(200)
    // create() {
    //     return "this action adds a new post"
    // }
    // @Post("cache")
    // @Header('Cache-Control', 'none')
    // create2() {
    //     return 'This action adds a new cat';
    // }
    // @Get(':id')
    // findOne(@Param() params): string {
    //     console.log(params.id);
    //     return `This action returns a #${params.id} cat`;
    // }
    // @Get('list/:id')
    // findOne2(@Param('id') id): string {
    //     return `This action returns a #${id} cat`;
    // }
    // @Get("async/promise")
    // async findAll2(): Promise<any[]> {
    //     return [];
    // }
    // @Get("async/rxjs")
    // findAll3(): Observable<any[]> {
    //     return of(["rxjs", "rxjs2", "exjs3"]);
    // }

    // // 这里有一点说明,就是默认的参数形式是x-www-form-urlencoded
    // @Post("async/bodydto")
    // async create3(@Body() createCatDto: CreateCatDto) {
    //     return "this is new Body post name param Body()"+`your param is createCatDto:name${createCatDto.name}, createCatDto:age: ${createCatDto.age}`
    // }

    // 这里使用service

    @Post()
    async create(@Body() createCatDto:CreateCatDto){
        this.catsService.create(createCatDto);
    }

    @Get()
    async findAll(): Promise<Cat[]> {
      return this.catsService.findAll();
    }
















    /** ***************/
    /**
     * 
     * 
     * 使用REQ的Express的书写方式,特点是直接使用了express封装好的Status和Code
     * 这是极其不推荐的做法,推荐使用上门的写法, 
     * 不推荐的原因是,因为太过于依赖Express,如果某一天改变了底层的HTTP库,那么会改变大量的代码,带来问题
     */
    // @Post()
    // create(@Res() res: Response) {
    //   res.status(HttpStatus.CREATED).send();
    // }
  
    // @Get()
    // findAll(@Res() res: Response) {
    //    res.status(HttpStatus.OK).json([]);
    // }
}

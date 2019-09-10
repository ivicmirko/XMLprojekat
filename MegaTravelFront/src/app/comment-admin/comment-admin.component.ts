import { Component, OnInit } from '@angular/core';
import { RatingService } from '../service/Rating/rating.service';
import { Comment } from '../model/comment';
import { PublishCommentDTO } from '../model/publish-comment-dto';

@Component({
  selector: 'app-comment-admin',
  templateUrl: './comment-admin.component.html',
  styleUrls: ['./comment-admin.component.scss']
})
export class CommentAdminComponent implements OnInit {

  comments:Comment[];

  constructor(private ratingService:RatingService) { }

  ngOnInit() {

    this.ratingService.getAllComments().subscribe(data=>{
      this.comments=data;
      console.log(this.comments);
    },error=>{
      console.log('neuspenso svi komentari');
    });
  }

  publishComment(id:Number){
    let dto=new PublishCommentDTO;
    dto.id=id;
    dto.flag=true;
    console.log(dto);
    this.ratingService.publishComment(dto).subscribe(data=>{
       alert('komentar objavljen');
      window.location.reload();
    },error=>{
      console.log('neuspesno publish');
    })
  }

  hajmo(id:Number){
    let dto=new PublishCommentDTO;
    dto.id=id;
    this.ratingService.hajde(dto).subscribe(data=>{
      alert('komentar objavljen');
      //window.location.reload();
    },error=>{
      console.log('neuspesno publish');
    })
  }

}

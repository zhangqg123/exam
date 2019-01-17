INSERT  INTO
	lh_exam_score
      ( 
      ID                            
      ,EXAM_ID                        
      ,OPEN_ID                        
      ,SCORE     
      ,NUMBER
      ) 
values
      (
      :lhExamScore.id                            
      ,:lhExamScore.examId                        
      ,:lhExamScore.openId                        
      ,:lhExamScore.score    
      ,:lhExamScore.number      
      )
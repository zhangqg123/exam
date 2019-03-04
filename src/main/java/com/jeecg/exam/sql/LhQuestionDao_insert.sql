INSERT  INTO
	lh_question
      ( 
      ID                            
      ,SUBJECT                        
      ,SUMMARY                        
      ,CHOOSE_ANSWER                  
      ,CHOOSE_NUMBER                  
      ,COLUMN_ID                      
      ,TYPE                           
      ,RIGHT_ANSWER                   
      ,NUMBER                         
      ,CREATE_BY                      
      ,CREATE_DATE                    
      ,REMARK    
      ,analysis
      ) 
values
      (
      :lhQuestion.id                            
      ,:lhQuestion.subject                       
      ,:lhQuestion.summary                       
      ,:lhQuestion.chooseAnswer                  
      ,:lhQuestion.chooseNumber                  
      ,:lhQuestion.columnId                      
      ,:lhQuestion.type                          
      ,:lhQuestion.rightAnswer                   
      ,:lhQuestion.number                        
      ,:lhQuestion.createBy                      
      ,:lhQuestion.createDate                    
      ,:lhQuestion.remark                        
      ,:lhQuestion.analysis                       
      )
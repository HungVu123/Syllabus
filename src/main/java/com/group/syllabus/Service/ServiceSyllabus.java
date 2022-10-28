package com.group.syllabus.Service;


import com.group.syllabus.DTO.*;
import com.group.syllabus.Repository.DeliveryPrincipleRepository;
import com.group.syllabus.Repository.SyllabusRepository;
import com.group.syllabus.Repository.SyllabusSessionRepository;
import com.group.syllabus.model.DeliveryPrinciple;
import com.group.syllabus.model.Syllabus;
import com.group.syllabus.model.SyllabusSession;
import com.group.syllabus.model.SyllabusUnit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSyllabus {
    @Autowired
    private SyllabusRepository syllabusRepository;
    @Autowired
    private SyllabusSessionRepository syllabusSessionRepository;
    @Autowired
    private DeliveryPrincipleRepository deliveryPrincipleRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Syllabus CreateSyllabus(SyllabusDTO syllabus){
        try {
            SyllabusSessionDTO syllabusSessionDTOS = new SyllabusSessionDTO();
            SyllabusUnitDTO syllabusUnitDTO = new SyllabusUnitDTO();
            SyllabusUnitChapterDTO syllabusUnitChapterDTO = new SyllabusUnitChapterDTO();
            for(int i =0 ;i<syllabus.getSyllabusSessionDTO().size();i++){
                syllabusSessionDTOS.setSessionNo(syllabus.getSyllabusSessionDTO().get(i).getSessionNo());
                syllabusSessionDTOS.setStatus(syllabus.getSyllabusSessionDTO().get(i).getStatus());
            syllabusSessionRepository.save(modelMapper.map(syllabusSessionDTOS, SyllabusSession.class));
                for (int j = 0; j<syllabus.getSyllabusSessionDTO().get(i).getSyllabusUnit().size();i++){
                    syllabusSessionDTOS.setSessionNo(syllabus.getSyllabusSessionDTO().get(j).getSessionNo());
                    syllabusSessionDTOS.setStatus(syllabus.getSyllabusSessionDTO().get(j).getStatus());
                    syllabusSessionRepository.save(modelMapper.map(syllabusSessionDTOS, SyllabusSession.class));
                    for (int k = 0; k<syllabus.getSyllabusSessionDTO().get(j).getSyllabusUnit().get(j).getSyllabusUnitChapter().size();i++){
                        syllabusSessionDTOS.setSessionNo(syllabus.getSyllabusSessionDTO().get(k).getSessionNo());
                        syllabusSessionDTOS.setStatus(syllabus.getSyllabusSessionDTO().get(k).getStatus());
                        syllabusSessionRepository.save(modelMapper.map(syllabusSessionDTOS, SyllabusSession.class));

                        /// "outputStandard":

                        ///"deliveryType":

                        ///"material":

                    }
                }
            }

            DeliveryPrincipleDTO deliveryPrincipleDTOS = new DeliveryPrincipleDTO();
            for(int i =0 ;i<syllabus.getDeliveryPrincipleDTO().size();i++){
                deliveryPrincipleDTOS.setContent(syllabus.getDeliveryPrincipleDTO().get(i).getContent());
             deliveryPrincipleRepository.save(modelMapper.map(deliveryPrincipleDTOS, DeliveryPrinciple.class));
            }
            SyllabusLevelDTO syllabusLevel = new SyllabusLevelDTO();
            syllabusLevel.setLevelName(syllabus.getSyllabusLevel().getLevelName());
            syllabus.setSyllabusLevel(syllabusLevel);

        }catch(Exception e){
            System.out.println(e);
        }

     return syllabusRepository.save(modelMapper.map(syllabus,Syllabus.class));
    }

}

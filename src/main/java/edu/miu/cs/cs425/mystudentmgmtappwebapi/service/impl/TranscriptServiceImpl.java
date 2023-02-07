package edu.miu.cs.cs425.mystudentmgmtappwebapi.service.impl;

import edu.miu.cs.cs425.mystudentmgmtappwebapi.model.Transcript;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.repository.TranscriptRepository;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.service.TranscriptService;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {

    private TranscriptRepository transcriptRepository;

    public TranscriptServiceImpl(TranscriptRepository transcriptRepository) {
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public Transcript addNewTranscript(Transcript newTranscript) {
        return transcriptRepository.save(newTranscript);
    }


}

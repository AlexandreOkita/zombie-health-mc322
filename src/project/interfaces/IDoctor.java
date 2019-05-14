package project.interfaces;

public interface IDoctor extends IEnquirer, IAnswerReceptacle, ITableProducerReceptacle, ITreeProducerReceptacle{
    public void connect(IAnswer responder);
    public void connect(ITreeProducer tree);
}

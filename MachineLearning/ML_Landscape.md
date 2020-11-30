# ML Landscape

## What is ML

Science of programming computers so they can learn from data

Data examples are called **training sets**. Each training example is called a **training instance**
Performance is measured in **accuracy**

ML is good in solving problems that either:

1. problems are too complex for traditonal approaches
2. have no known algoritme/can help find an algoritme
3. fluctuating environments: ML can learn machines to adapt to new data
4. can help humans learn to get insight in complex and large amount of data => data mining

|  | Description | Example |
| :---|    :----   | :---- |
| CNN | Convolutional Neural Netwerk | Image Classification 
|  |Segmantic Segmentation  | Brain scans |
| NLP | Natural Language Processing | News articles classification|
|  |  | Text Summary | 
| RNN | Recurring Neural Netwerk | News articles classification |
| NLU | Natural Language Understanding | Chatbot/personal assistant |
| SVM | Support Vector Machine | Forecasting |
| RL | Reinformcement Learning | |

**Regression model**:

- Linear
- Polynomial
- Random Forest
- when take past in account then RNN, CNN, Transformers

dimensionality reduction: Simplify the data without loosing too much information.
Feature extraction: merge one feature in an other and both will represent an new feature.

Anomaly detection: unusual credit card transactions to prevent fraud.
Novelty detection: detact new instances that look different from all training instances.

Association rule learning: dig in large datasets and discover interesting reations between attributes.

## Types of ML

1. **Supervised Learning**
    - Classification
    - K-Nearest Neighbours
    - Linear/Logistic regression (both predictor and their labels required)
    - SVM
    - Decision Tree
    - Random Forests
    - Neural Networks
2. **Unsupervised Learning**
    - Clustering
        - K-Means
        - DBSCAN
        - HCA (Hierarchical Cluster Analysis)
    - Anomaly detection an novelty detection
        - One-class SVM
        - Isolation Forest
    - Visualistation and dimensionality reduction
        - PCS (Principal Component Analysis)
        - Kernel PCA
        - LLE (Locally Linear Embedding)
        - t-SNE (t-Distributed Stochastic Neigbor Embedding)
    - Association rule learning
        - Apriori
        - Eclat
3. **Semi-supervised Learning**
    - partly labeled
    - mostly combination of supervised and unsupervised learning
    - DBN (Deep Believe Networks)
    - RBM (Resticted Boltzmann Machines)
4. **Reinforcement Learning**
    - Call an agent, observe the environment, select and perform actions, get reward or penalty. Learns by itself.


    
